package PktNotasFinales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClsNotasFinales {

    // DEFINICIÓN DE METODOS
    
    // METODO QUE CALCULA EL PROMEDIO
    private static float mtdPromedio(int nota1,int nota2, int nota3){
        return (float) ((nota1+nota2+nota3)/3.0);
    }

    // METODO QUE CALCULA LA NOTA FINAL 
    private static char mtdNotaFinal(float promedio){
        char notaFinal=0;
        if(promedio<61){
            notaFinal='F';
        }else if(promedio<71){
            notaFinal='D';
        }else if(promedio<81){
            notaFinal='C';
        }else if(promedio<91){
            notaFinal='B';
        }else{
            notaFinal='A';
        }
        return notaFinal;
    }

    public static void main(String[] args) throws IOException {
        
        // DEFINICIÓN DE OBJETOS
        BufferedReader objLeer = new BufferedReader(new InputStreamReader(System.in));

        // DEFINICIÓN DE VARIABLES
        String nombre, opcionSalida;
        int nota1=0, nota2=0, nota3=0, opcionMenu=0;
        boolean salida=true;
        float promedio=0;
        char notaFinal; // CAMBIOS
        int variable;
        int variable2;

        while(salida){
            
            // ENTRADA DE DATOS
            System.out.print("\nIntroduzca el nombre del estudiante: ");
            nombre= objLeer.readLine();
            System.out.print("Introduzca la primera nota: ");
            nota1= Integer.parseInt(objLeer.readLine());
            System.out.print("Introduzca la segunda nota: ");
            nota2= Integer.parseInt(objLeer.readLine());
            System.out.print("Introduzca la tercera nota: ");
            nota3= Integer.parseInt(objLeer.readLine());
            salida= false;  
            
            // CALCULO DEL PROMEDIO
            promedio= mtdPromedio(nota1,nota2,nota3);
            
            //  CICLO DE CONTROL DEL MENU
            opcionMenu=0;
            while(opcionMenu!=3){
                // DETERMINAR OPCIONES
                System.out.println("\n1.MOSTRAR NOMBRE Y PROMEDIO DEL ESTUDIANTE\n2.MOSTRAR NOMBRE Y NOTA FINAL DEL ESTUDIANTE\n3.SALIR\nElija una opción:");
                opcionMenu= Integer.parseInt(objLeer.readLine());
                switch (opcionMenu) {
                    case 1:
                        System.out.println("\nEstudiante: "+nombre+"\nPromedio: "+promedio);
                        break;
                    case 2:
                        System.out.println("\nEstudiante: "+nombre+"\nNota Final: "+mtdNotaFinal(promedio));
                        break;
                    case 3:
                        break;
                    default: System.out.println("\nOpción incorrecta, seleccione una nueva");
                        continue; // INNECESARIO
                }
            }
            System.out.println("\nDesea Introduccior otro estudiante? (S/N)");
            opcionSalida= objLeer.readLine();
            if(opcionSalida.equalsIgnoreCase("N")){
                System.out.println("La ejecución del programa ha finalizado\n");
                salida=false;
            }else{
                salida=true;
            }
        }
    }
}
