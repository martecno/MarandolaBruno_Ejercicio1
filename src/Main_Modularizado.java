import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main_Modularizado {

	public static void main(String[] args) {
		int cantidadUnitariaProducto;
		int cantidadTotalProductos;
		Double valorProducto;
		Double valorProductoTotal = 0.0;
		Double valorTotalConIVA = 0.0;
		Double valorTotal = 0.0;
		Double ivaTotal = 0.0;
		Double iva = 0.21;
		String producto;
		String razonSocial;
		String domicilio;
		String ticket = "";
		String sn;

		Scanner scan = new Scanner(System.in);

		String date = date();

		razonSocial = razonSocial(scan);
		domicilio = domicilio(scan);
//		cantidadTotalProductos = cantidadDeProductos(scan);
		System.out.println("Desea cargar más productos? (S/N)");
		sn = scan.nextLine();

		while (sn.equals("s")) {
			producto = producto(scan);
			cantidadUnitariaProducto = cantidadProducto(scan);
			valorProducto = precioUnitario(scan);
			valorProductoTotal = (valorProducto * cantidadUnitariaProducto);
			valorTotal += valorProductoTotal;
			ticket = extracted(cantidadUnitariaProducto, valorProducto, valorProductoTotal, producto, ticket);
			System.out.println("Desea cargar más productos? (S/N)");
			scan.nextLine();
			sn = scan.nextLine();
		}

		ivaTotal += (valorTotal * iva);
		valorTotalConIVA = ivaTotal + valorTotal;
		impresion(valorTotalConIVA, valorTotal, ivaTotal, razonSocial, domicilio, ticket, date);
	}

	private static void impresion(Double valorTotalConIVA, Double valorTotal, Double ivaTotal, String razonSocial,
			String domicilio, String ticket, String date) {
		System.out.println("");
		System.out.println("*************************************************************************************");
		System.out.println("Fecha: " + date);
		System.out.println("*************************************************************************************");
		System.out.println("Nombre: " + razonSocial);
		System.out.println("Domicilio: " + domicilio);
		System.out.println(ticket);
		System.out.println("-------------------------------------------------------------------------------------");
		System.out.println("IVA: " + ivaTotal);
		System.out.println("Subtotal (sin IVA): " + (valorTotal));
		System.out.println("Total: " + valorTotalConIVA);
	}

	private static Double precioUnitario(Scanner scan) {
		Double valorProducto;
		System.out.println("Ingrese el valor unitario (sin IVA) del producto");
		valorProducto = scan.nextDouble();
		return valorProducto;
	}

	private static int cantidadProducto(Scanner scan) {
		int cantidadUnitariaProducto;
		System.out.println("Ingrese la cantidad de unidades del producto");
		cantidadUnitariaProducto = scan.nextInt();
		return cantidadUnitariaProducto;
	}

	private static String producto(Scanner scan) {
		String producto;
		System.out.println("Ingrese el producto de la compra");
		producto = scan.nextLine();
		return producto;
	}

	private static int cantidadDeProductos(Scanner scan) {
		int cantidadTotalProducctos;
		System.out.println("Ingrese la cantidad de productos");
		cantidadTotalProducctos = scan.nextInt();
		return cantidadTotalProducctos;
	}

	private static String domicilio(Scanner scan) {
		String domicilio;
		System.out.println("Ingrese el domicilio");
		domicilio = scan.nextLine();
		return domicilio;
	}

	private static String razonSocial(Scanner scan) {
		String razonSocial;
		System.out.println("Ingrese la razón social del comprador");
		razonSocial = scan.nextLine();
		return razonSocial;
	}

	private static String date() {
		Date fecha = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyy");
		sdf.format(fecha);
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		return date;
	}

	private static String extracted(int cantidadUnitariaProducto, Double valorProducto, Double valorProductoTotal,
			String producto, String ticket) {
		ticket += ("\n*************************************************************************************\nCant. "
				+ "\t| Descripcion\t\t\t| P. unit\t\t | P. total"
				+ "\n-------------------------------------------------------------------------------------\n"
				+ cantidadUnitariaProducto + "\t| " + producto + " \t\t\t|" + valorProducto + " \t\t|"
				+ valorProductoTotal);
		return ticket;
	}

}
