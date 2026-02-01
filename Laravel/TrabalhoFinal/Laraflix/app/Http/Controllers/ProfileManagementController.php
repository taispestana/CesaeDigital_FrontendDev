<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class ProfileManagementController extends Controller
{
    /**
     * Display the profile management page.
     */
    public function index()
    {
        $users = \App\Models\User::all();
        return view('profiles.manage', compact('users'));
    }

    /**
     * Display the profile edit page.
     */
    public function edit(\App\Models\User $user)
    {
        return view('profiles.edit', compact('user'));
    }

    /**
     * Update the user profile.
     */
    public function update(\Illuminate\Http\Request $request, \App\Models\User $user)
    {
        $request->validate([
            'name' => 'required|string|max:255',
            'profile_photo' => 'nullable|image|mimes:jpeg,png,jpg,gif|max:2048',
        ]);

        $data = [
            'name' => $request->name,
        ];

        if ($request->hasFile('profile_photo')) {
            // Delete old photo if it exists
            if ($user->profile_photo_path && \Illuminate\Support\Facades\Storage::disk('public')->exists($user->profile_photo_path)) {
                \Illuminate\Support\Facades\Storage::disk('public')->delete($user->profile_photo_path);
            }

            $path = $request->file('profile_photo')->store('profile-photos', 'public');
            $data['profile_photo_path'] = $path;
        }

        $user->update($data);

        return redirect()->route('profiles.manage')->with('success', 'Perfil atualizado com sucesso!');
    }


    /**
     * Delete a user profile.
     */
    public function destroy(\App\Models\User $user)
    {
        $currentUser = \Illuminate\Support\Facades\Auth::user();

        if (!$currentUser->isAdmin()) {
            abort(403, 'Ação não autorizada.');
        }

        // If deleting the current user, log them out first
        if ($currentUser->id === $user->id) {
            \Illuminate\Support\Facades\Auth::logout();
            $user->delete();
            return redirect('/')->with('success', 'A sua conta foi eliminada.');
        }

        $user->delete();
        return redirect()->route('profiles.manage')->with('success', 'Perfil eliminado com sucesso.');
    }

    /**
     * Show the form for creating a new profile.
     */
    public function create()
    {
        return view('profiles.create');
    }

    /**
     * Store a newly created profile in storage.
     */
    public function store(\Illuminate\Http\Request $request)
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

        \App\Models\User::create([
            'name' => $request->name,
            'email' => $request->email,
            'password' => \Illuminate\Support\Facades\Hash::make('laraflix123'),
            'role' => 'user',
            'profile_photo_path' => $profilePhotoPath,
        ]);

        return redirect()->route('profiles.manage')->with('success', 'Novo perfil adicionado com sucesso!');
    }

    /**
     * Switch the current user profile.
     */
    public function switch(\App\Models\User $user)
    {
        \Illuminate\Support\Facades\Auth::login($user);
        return redirect()->route('dashboard')->with('success', 'Perfil alterado para ' . $user->name);
    }
}

