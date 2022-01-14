package com.company;

import Modelo.Estudio;
import Modelo.Pelicula;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    // Todos los estudios que existen en el mundo
    private static Estudio[] listaEstudios;

    // Todos las pelÃ­culas que existen en el mundo
    private static ArrayList<Pelicula> listaPeliculas;

    public static void main(String[] args) {
        try{
            crearEstudios();
            crearPeliculas();
            buscarPeliculaMasLarga();
            buscarEstudioConMasPeliculas();
        }
        catch(Exception e)
        {
            javax.swing.JOptionPane.showMessageDialog(null,e.getClass());
        }
    }
    public static void crearEstudios() throws Exception{
        // Crear objetos de tipo estudio sin pelÃ­culas

        listaEstudios = new Estudio[5];
        // Lista de telefonos
        ArrayList<String> telefonos = new ArrayList();
        telefonos.add("111111111");
        telefonos.add("111111112");
        listaEstudios[0] = new Estudio("Universal", "Los Angeles"," C/ a","www.universal.es", LocalDate.of(1950,9,23),"EEUU",telefonos);



        telefonos = new ArrayList();
        telefonos.add("222222222");
        telefonos.add("222222223");
        listaEstudios[1] = new Estudio("Walt Disney", "Los Angeles"," C/ b","www.disney.es",LocalDate.of(1960,9,23),"EEUU",telefonos);



        telefonos = new ArrayList();
        telefonos.add("333333333");
        telefonos.add("333333334");
        //listaEstudios[2] = new Estudio("Warner Bros", "California"," C/ c","www.warner.es",LocalDate.of(1956,1,10),"EEUU",telefonos);
        listaEstudios[2] = new Estudio();
        listaEstudios[2].setNombre("Warner Bros");
        listaEstudios[2].setPais("EEUU");
        listaEstudios[2].setCiudad("California");
        listaEstudios[2].setDireccion(" C/ c");
        listaEstudios[2].setDirWeb("www.warner.es");
        listaEstudios[2].setTelefonos(telefonos);
        listaEstudios[2].setFundacion(LocalDate.of(1956,01,10));



        /*telefonos = new ArrayList();
        telefonos.add("444444444");
        telefonos.add("444444445");*/
        listaEstudios[3] = new Estudio("Paramount", "Los Angeles"," C/ d","www.paramount.es",LocalDate.of(1955,9,23),"EEUU");
        listaEstudios[3].setTelefono("444444444");
        listaEstudios[3].setTelefono("444444445");


        telefonos = new ArrayList();
        telefonos.add("555555555");
        telefonos.add("555555556");
        listaEstudios[4] = new Estudio("20Th Century Fox", "Los Angeles"," C/ e","www.fox.es",LocalDate.of(1953,9,23),"EEUU",telefonos);
    }

    public static void crearPeliculas() throws Exception{
        // Creo peliculas ya con los estudios
        listaPeliculas = new ArrayList();

        // Estudios de la pelÃ­cula
        ArrayList <Estudio> lista = new ArrayList();
        lista.add(listaEstudios[0]);
        lista.add(listaEstudios[2]);
        Pelicula p = new Pelicula("ET",1980,90.7f,"Infantil",lista);
        listaPeliculas.add(p);


        int año = 1997;
        // Estudios de la pelÃ­cula
        lista = new ArrayList();
        lista.add(listaEstudios[1]);
        lista.add(listaEstudios[2]);
        listaPeliculas.add(new Pelicula("Titanic",año,180,"RomÃ¡ntica",lista));



        año = 2003;
        // Estudios de la pelÃ­cula
        lista = new ArrayList();
        lista.add(listaEstudios[4]);
        listaPeliculas.add(new Pelicula("El seÃ±or de los anillos",año,133,"Ciencia ficciÃ³n",lista));



        año = 2003;
        // Estudios de la pelÃ­cula
        lista = new ArrayList();
        lista.add(listaEstudios[3]);
        lista.add(listaEstudios[4]);
        lista.add(listaEstudios[1]);
        lista.add(listaEstudios[2]);
        listaPeliculas.add(new Pelicula("Piratas del Caribe",año,220,"Aventuras",lista));



        año = 1994;
        // Estudios de la pelÃ­cula
        lista = new ArrayList();
        lista.add(listaEstudios[1]);
        listaPeliculas.add(new Pelicula("El rey leÃ³n",año,97,"Infantil",lista));
    }

    public static void buscarPeliculaMasLarga() throws Exception{
        float maximo = 0;
        Pelicula objeto=null;
        for(int x=0; x < listaPeliculas.size();x++)
        {
            if (listaPeliculas.get(x).getDuracion() > maximo)
            {
                maximo = listaPeliculas.get(x).getDuracion();
                objeto = listaPeliculas.get(x);
                // TambiÃ©n me puedo quedar con la posiciÃ³n
            }
        }

        // Nombre de todos los estudios que han producido la pelÃ­cula
        String mensaje = "";
        for (int x = 0; x < objeto.getEstudiosCine().size();x++)
            mensaje += " " + objeto.getEstudiosCine().get(x).getNombre();

        javax.swing.JOptionPane.showMessageDialog(null," La pelicula mÃ¡s larga es " + objeto.getTitulo()+ " y se ha producido en " + mensaje);
    }

    public static void buscarEstudioConMasPeliculas() throws Exception{
        // En estudio No tengo las pelÃ­culas
        // contador de peliculas de cada estudio
        // arrays coincidentes
        int [] numeroPeliculas = new int[5];
        Arrays.fill(numeroPeliculas, 0);

        // Por cada Estudio recorro la lista de todas las pelÃ­culas para ver si estÃ¡ o no.
        for(int z = 0;z < listaEstudios.length; z++)
            for(int x=0; x < listaPeliculas.size();x++)
            {
                boolean salir = false;
                for(int y=0; y < listaPeliculas.get(x).getEstudiosCine().size() && !salir; y++)
                {
                    //if (listaPeliculas.get(x).getListaEstudios().get(y)== listaEstudios[z])
                    if (listaPeliculas.get(x).getEstudiosCine().get(y).equals(listaEstudios[z]))
                    {
                        numeroPeliculas[z]+= 1;
                        salir = true;
                    }
                }
            }

        // Busco el mÃ¡ximo contador
        int maximo = 0;
        int posicion = 0;
        for (int x = 0; x < numeroPeliculas.length; x++)
            if(numeroPeliculas[x] > maximo)
            {
                maximo = numeroPeliculas[x];
                posicion = x;
            }

        javax.swing.JOptionPane.showMessageDialog(null,"El estudio que más peliculas ha producido es: " + listaEstudios[posicion].getNombre() + " y ha producido "+ maximo);
    }

}



