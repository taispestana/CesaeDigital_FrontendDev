package FichaPratica01;

import java.util.Scanner;

public class Ex08 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        int segundosMusica, minutosMusica, segundosTotaisAlbum = 0;

        System.out.println("Introduza minutos da musica 1: ");
        minutosMusica = input.nextInt();

        System.out.println("Introduza segundos da musica 1: ");
        segundosMusica = input.nextInt();

        segundosTotaisAlbum = segundosTotaisAlbum + (minutosMusica*60) + segundosMusica;

        System.out.println("Introduza minutos da musica 2: ");
        minutosMusica = input.nextInt();
        System.out.println("Introduza segundos da musica 2: ");
        segundosMusica = input.nextInt();

        segundosTotaisAlbum = segundosTotaisAlbum + (minutosMusica*60) + segundosMusica;

        System.out.println("Introduza minutos da musica 3: ");
        minutosMusica = input.nextInt();
        System.out.println("Introduza segundos da musica 3: ");
        segundosMusica = input.nextInt();

        segundosTotaisAlbum = segundosTotaisAlbum + (minutosMusica*60) + segundosMusica;

        System.out.println("Introduza minutos da musica 4: ");
        minutosMusica = input.nextInt();
        System.out.println("Introduza segundos da musica 4: ");
        segundosMusica = input.nextInt();

        segundosTotaisAlbum = segundosTotaisAlbum + (minutosMusica*60) + segundosMusica;

        System.out.println("Introduza minutos da musica 5: ");
        minutosMusica = input.nextInt();
        System.out.println("Introduza segundos da musica 5: ");
        segundosMusica = input.nextInt();

        segundosTotaisAlbum = segundosTotaisAlbum + (minutosMusica*60) + segundosMusica;

        int horas, minutos, segundos;

        horas = segundosTotaisAlbum / 3600;
        minutos = (segundosTotaisAlbum / 60) - (horas * 60);
        segundos = segundosTotaisAlbum - (horas*3600) - (minutos*60);

        System.out.println("Total: "+horas+"h"+minutos+"m"+segundos+"s");

    }
}
