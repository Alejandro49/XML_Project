package xml;

import com.saxonica.xqj.SaxonXQDataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.xquery.XQConnection;
import javax.xml.xquery.XQDataSource;
import javax.xml.xquery.XQException;
import javax.xml.xquery.XQPreparedExpression;
import javax.xml.xquery.XQResultSequence;

public class LigaXQuery {
	
        private void ejecutarConsultaPredefinida(int opcion) throws XQException {
        		
        		String ruta1 = "./xml/xquery1.xq";
        		String ruta2 = "./xml/xquery2.xq";
        		String ruta3 = "./xml/xquery3.xq";
        		String ruta4 = "./xml/xquery4.xq";
        		
        		File queryFile = new File(ruta1);
        		
        		switch (opcion) {
        		case 1:
        			queryFile = new File(ruta1);
        		break;
        		case 2:
        			queryFile = new File(ruta2);
        		break;
        		case 3:
        			queryFile = new File(ruta3);
        		break;
        		case 4:
        			queryFile = new File(ruta4);
        		break;
        		}
              

                XQDataSource xqjd = new SaxonXQDataSource();
                XQConnection xqjc = xqjd.getConnection();
                InputStream inputStream = null;
                try {
                    inputStream = new FileInputStream(queryFile);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(LigaXQuery.class.getName()).log(Level.SEVERE, null, ex);
                }
                XQPreparedExpression exp = xqjc.prepareExpression(inputStream);
                XQResultSequence result = exp.executeQuery();
                while (result.next()) {
                    System.out.println(result.getItemAsString(null));
                    esperar(1);
                }
                result.close();
                exp.close();
                xqjc.close();
        }
        
        public void consultasPredefinidas() throws XQException {
        	mostrarConsultasPredefinidas();
        	System.out.println("Escriba el nº de consulta que quiere ejecutar");
        	Scanner sc = new Scanner(System.in);
        	int sentencia = 0;
        	try {
        		sentencia = sc.nextInt();
        	} catch (InputMismatchException ime){
    			System.out.println("Debes introducir un número entero. Vuelve a intentarlo");
    			esperar(2);
    			consultasPredefinidas();
    		}
        	sc.nextLine();
        	if (sentencia>0 && sentencia<5) {
        		ejecutarConsultaPredefinida(sentencia);
        		esperar(2);
        	} else {
        		System.out.println("Opcion incorrecta");
        	}
        	System.out.println("Escriba \"ok\" para seguir ejecutando consultas XPath o cualquier tecla para volver al menu principal");
    		String confirmacion = sc.nextLine();
    		if (confirmacion.equals("ok")) {
    			consultasPredefinidas();
    		} else {
    			return;
    		}
        	
        }
        
        private void mostrarConsultasPredefinidas() {
        	System.out.println("1º- Mostrar equipos ordenados según el número de titulos");
        	System.out.println("2º- Mostrar presidente del Real Madrid");
        	System.out.println("3º- Mostrar entrenadores de los equipos franceses");
        	System.out.println("4º- Mostrar equipos españoles");
        }
        
        public static void esperar(int segundos){
            try {
                Thread.sleep(segundos * 1000);
             } catch (Exception e) {
                System.out.println(e);
             }
        }   
}