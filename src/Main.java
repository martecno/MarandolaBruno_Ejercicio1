import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int cantidad1;
		int cantidad2;
		Double valorProducto1;
		Double valorProducto2;
		Double valorProductoTotal1;
		Double valorProductoTotal2;
		Double valorTotalConIVA;
		Double valorTotal;
		Double ivaTotal;
		Double iva = 0.21;
		String producto1;
		String producto2;
		String razonSocial;
		String domicilio;

		Scanner scan = new Scanner(System.in);
		Date fecha = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy");
		sdf.format(fecha);
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String date = simpleDateFormat.format(new Date());

		System.out.println("Ingrese la razón social del comprador");
		razonSocial = scan.nextLine();
		System.out.println("Ingrese el domicilio");
		domicilio = scan.nextLine();

		System.out.println("Ingrese el primer producto de la compra");
		producto1 = scan.nextLine();
		System.out.println("Ingrese la cantidad de unidades del primer producto");
		cantidad1 = scan.nextInt();
		System.out.println("Ingrese el valor unitario (sin IVA) del primer producto");
		valorProducto1 = scan.nextDouble();
		System.out.println("Ingrese el segundo producto de la compra");
		scan.nextLine();
		producto2 = scan.nextLine();
		System.out.println("Ingrese la cantidad de unidades del primer producto");
		cantidad2 = scan.nextInt();
		System.out.println("Ingrese el valor unitario (sin IVA) del segundo prodcuto");
		valorProducto2 = scan.nextDouble();

		valorProductoTotal1 = (valorProducto1 * cantidad1);
		valorProductoTotal2 = (valorProducto2 * cantidad2);
		valorTotal = (valorProductoTotal1 + valorProductoTotal2);
		ivaTotal = ((valorProductoTotal1 * iva) + (valorProductoTotal2 * iva));
		valorTotalConIVA = ivaTotal + valorTotal;

		System.out.println("");
		System.out.println("*************************************************************************************");
		System.out.println("Fecha: " + date);
		System.out.println("*************************************************************************************");
		System.out.println("Nombre: " + razonSocial);
		System.out.println("Domicilio: " + domicilio);
		System.out.println("*************************************************************************************");
		System.out.println("Cant. | Descripcion | P. unit | P. total");
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println(cantidad1 + "      | " + producto1 + " |" + valorProducto1 + " |" + valorProductoTotal1);
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println(cantidad2 + "      | " + producto2 + " |" + valorProducto2 + " |" + valorProductoTotal2);
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("IVA: " + ivaTotal);
		System.out.println("Subtotal (sin IVA): " + (valorProductoTotal1 + valorProductoTotal2));
		System.out.println("Total: " + valorTotalConIVA);
	}

}
