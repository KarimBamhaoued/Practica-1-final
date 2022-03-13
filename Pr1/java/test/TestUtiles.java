package test;

import auxiliar.Utiles; // O bien    import auxiliar.Utiles;

/* Verificación Utiles.java */

class TestUtiles {


    public static void main(String [] args) {

        /** Verificación de_Array4Bytes_a_Long( byte[] ) */
        
        byte [] vector     = {14, 112, -78, 45};

        long t             = Utiles.de_Array4Bytes_a_Long( vector );
        byte [] vector_aux = Utiles.de_Long_a_Array4Bytes( t );
        
        for (int i = 0; i < 4; i++ ) {
            if ( vector_aux[i] != vector[i] ) {
                System.out.println("Error en de_Array4Bytes_a_Long( byte[] ).");
                break; // Ya no es necesario continuar
            }
            System.out.println("vector_aux[" + i + "]=vector["+ i + "]=" + vector_aux[i]); 
        }

        // Re-verificación:

        long t_aux = Utiles.de_Array4Bytes_a_Long( vector_aux );        
        if ( t == t_aux ) {
            System.out.println("t=" + t + "==" + t_aux + "=t_aux. Rutinas de conversion OK");
        } else {
            System.out.println("t=" + t + "!=" + t_aux + "=t_aux. Rutinas de convesion ERROR");
        }


        /** Verificación de de_UTC_a_hms() */

        long CeroHoras_UnoDeEneroDe2020 = 3786825600L; // 00:00:00 de 1/1/2020
        byte [] hms = Utiles.de_UTC_a_hms(CeroHoras_UnoDeEneroDe2020);

        System.out.println("00:00:00 del 1-enero-2020 = " + hms[0] + ":" + hms[1] + ":" + hms[2] );

    }


}