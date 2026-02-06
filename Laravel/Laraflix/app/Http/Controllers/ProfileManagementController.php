<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;
use App\Models\User;
use Illuminate\Support\Facades\Storage;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\Hash;

class ProfileManagementController extends Controller
{
    /**
     * Função que exibe a página de gerenciamento de perfis
     */
    public function index()
    {
        $users = User::all();
        return view('profiles.manage', compact('users'));
    }

    /**
     * Função que exibe a página de edição de perfil
     */
    public function edit(User $user)
    {
        return view('profiles.edit', compact('user'));
    }

    /**
     * Função que atualiza o perfil do usuário
     */
    public function update(Request $request, User $user)
    {
        $request->validate([
            'name' => 'required|string|max:255',
            'profile_photo' => 'nullable|image|mimes:jpeg,png,jpg,gif|max:2048',
        ]);

        $data = [
            'name' => $request->name,
        ];

        if ($request->hasFile('profile_photo')) {
            // Deleta a foto antiga se existir
            if ($user->profile_photo_path && Storage::disk('public')->exists($user->profile_photo_path)) {
                Storage::disk('public')->delete($user->profile_photo_path);
            }

            $path = $request->file('profile_photo')->store('profile-photos', 'public');
            $data['profile_photo_path'] = $path;
        }

        $user->update($data);

        return redirect()->route('profiles.manage')->with('success', 'Perfil atualizado com sucesso!');
    }


    /**
     * Função que elimina um perfil de usuário
     */
    public function destroy(User $user)
    {
        $currentUser = Auth::user();

        if (!$currentUser->isAdmin()) {
            abort(403, 'Ação não autorizada.');
        }

        // Se estiver eliminando o próprio perfil, desloga o usuário
        if ($currentUser->id === $user->id) {
            Auth::logout();
            $user->delete();
            return redirect('/')->with('success', 'A sua conta foi eliminada.');
        }

        $user->delete();
        return redirect()->route('profiles.manage')->with('success', 'Perfil eliminado com sucesso.');
    }

    /**
     * Função que exibe o formulário para criar um novo perfil
     */
    public function create()
    {
        return view('profiles.create');
    }

    /**
     * Função que salva um novo perfil no banco de dados
     */
    public function store(Request $request)
    {
        $request->validate([
            'name' => 'required|string|max:255',
            'email' => 'required|email|unique:users,email',
            'profile_photo' => 'nullable|image|mimes:jpeg,png,jpg,gif|max:2048',
        ]);

        $profilePhotoPath = null;
        if ($request->hasFile('profile_photo')) {
            $profilePhotoPath = $request->file('profile_photo')->store('profile-photos', 'public');
        }

        User::create([
            'name' => $request->name,
            'email' => $request->email,
            'password' => Hash::make('laraflix123'),
            'role' => 'user',
            'profile_photo_path' => $profilePhotoPath,
        ]);

        return redirect()->route('profiles.manage')->with('success', 'Novo perfil adicionado com sucesso!');
    }

    /**
     * Função que altera o perfil atual
     */
    public function switch(User $user)
    {
        Auth::login($user);
        return redirect()->route('dashboard')->with('success', 'Perfil alterado para ' . $user->name);
    }
}

