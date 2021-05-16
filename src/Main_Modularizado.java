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

		razonSocial = solicitarStringPorTeclado("Ingrese la Razón Social");
		domicilio = solicitarStringPorTeclado("Ingrese el domicilio");
		sn = solicitarStringPorTeclado("Desea cargar más productos? (S/N)");

		while (sn.equals("s")) {
			producto = solicitarStringPorTeclado("Ingrese el producto");
			cantidadUnitariaProducto = solicitarIntPorTeclado("Ingrese la cantidad del producto");
			valorProducto = solicitarDoublePorTeclado("Ingrese el valor unitario (sin IVA) del producto");
			valorProductoTotal = (valorProducto * cantidadUnitariaProducto);
			valorTotal += valorProductoTotal;
			ticket = extracted(cantidadUnitariaProducto, valorProducto, valorProductoTotal, producto, ticket);
			sn = solicitarStringPorTeclado("Desea cargar más productos? (S/N)");
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

	private static int solicitarIntPorTeclado(String mensaje) {
		Scanner scan = new Scanner(System.in);
		System.out.println(mensaje);
		int valor = scan.nextInt();
		return valor;
	}

	private static Double solicitarDoublePorTeclado(String mensaje) {
		Scanner scan = new Scanner(System.in);
		System.out.println(mensaje);
		Double valor = scan.nextDouble();
		return valor;
	}

	private static String solicitarStringPorTeclado(String mensaje) {
		Scanner scan = new Scanner(System.in);
		System.out.println(mensaje);
		String valor = scan.nextLine();
		return valor;
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