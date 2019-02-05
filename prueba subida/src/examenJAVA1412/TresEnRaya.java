package examenJAVA1412;

public class TresEnRaya {
	public static int x1=0, x2=0, x3=0,
					  o1=0, o2=0, o3=0;
	public static void main(String[] args) {
		String lugarUsu="", repetir="s";
		System.out.println("¡BIENVENIDO AL JUEGO DE LAS DAMAS!");
		while(repetir.equals("s")) {
			while(quedanFichas()) {
				imprimeTablero();
				System.out.println("¡TU TURNO!");
				System.out.println("Elige donde quieres colocar tu ficha:");
				lugarUsu=Entrada.cadena().toLowerCase();
				while(!usuarioMueveFicha(lugarUsu)) {
					System.out.println("¡MOVIMIENTO ERRÓNEO!");
					System.out.println("Elige donde quieres colocar tu ficha:");
					lugarUsu=Entrada.cadena().toLowerCase();
				}
				System.out.println("¡MOVIMIENTO VÁLIDO!");
				imprimeTablero();
				System.out.println("¡TURNO DE LA MÁQUINA!");
				while(!mueveFichaAleatoria()) {
					System.out.println("¡MOVIMIENTO ERRONEO DE LA MÁQUINA!");
				}
				System.out.println("¡MOVIMIENTO VÁLIDO!");
			}
			imprimeTablero();
			if(ganaUsuario()) {
				System.out.println("¡GANASTES!");
			}else if(ganaPrograma()) {
				System.out.println("¡GANA LA MÁQUINA!");
			}else {
				System.out.println("¡EMPATE!");
			}
			System.out.println("¿Otra partidita? (s/n)");
			repetir=Entrada.cadena();
			if(repetir.equals("s")){
				limpiarTablero();
			}
		}
		System.out.println("¡ADIOS!");
	}
	public static void imprimeTablero() {
		for(int i=1;i<=9;i++) {
			if(i%3!=0) {
				if(i==x1 || i==x2 || i==x3) {
					System.out.print("x	");
				}else if(i==o1 || i==o2 || i==o3) {
					System.out.print("o	");
				}else {
					System.out.print("-	");
				}
			}else {
				if(i==x1 || i==x2 || i==x3) {
					System.out.println("x	");
				}else if(i==o1 || i==o2 || i==o3) {
					System.out.println("o	");
				}else {
					System.out.println("-	");
				}
			}
		}
	}
	public static boolean mueveFichaAleatoria() {
		int ficha=(int)(Math.random()*(9)+1);
		if(o1!=0 && o2==0 && o3==0) {
			if(ficha!=o1) {
				x1=ficha;
				return true;
			}else {
				return false;
			}
		}else if(o1!=0 && o2!=0 && o3==0) {
			if(ficha!=o1 && ficha!=o2 && ficha!=x1) {
				x2=ficha;
				return true;
			}else {
				return false;
			}
		}else if(o1!=0 && o2!=0 && o3!=0) {
			if(ficha!=o1 && ficha!=o2 && ficha!=o3 && ficha!=x1 && ficha!=x2) {
				x3=ficha;
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
	public static int convierteAPosicionMovimiento(String lugar) {
		switch(lugar) {
		case "arriba izquierda":
			return 1;
		case "arriba centro":
			return 2;
		case "arriba derecha":
			return 3;
		case "centro izquierda":
			return 4;
		case "centro centro":
			return 5;
		case "centro derecha":
			return 6;
		case "abajo izquierda":
			return 7;
		case "abajo centro":
			return 8;
		case "abajo derecha":
			return 9;
		default:
			return 0;
		}
	}
	public static boolean usuarioMueveFicha(String lugar) {
		int ficha=convierteAPosicionMovimiento(lugar);
		if(x1==0 && ficha!=0) {
			o1=ficha;
			return true;
		}else if(x1!=0 && x2==0 && o1!=0 && ficha!=0) {
			if(ficha!=x1 && ficha!=o1) {
				o2=ficha;
				return true;
			}else {
				return false;
			}
		}else if(x1!=0 && x2!=0 && x3==0 && ficha!=0) {
			if(ficha!=x1 && ficha!=x2  && ficha!=o1 && ficha!=o2) {
				o3=ficha;
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
	public static void limpiarTablero() {
		x1=0;
		x2=0;
		x3=0;
		o1=0;
		o2=0;
		o3=0;
	}
	public static boolean quedanFichas() {
		if(o1==0 || x1==0 || o2==0 || x2==0 || o3==0 || x3==0) {
			return true;
		}else {
			return false;
		}
	}
	public static boolean ganaPrograma() {
		if(x1==1 && (x2==2 || x2==3) && (x3==2 || x3==3) || 
		   x1==2 && (x2==1 || x2==3) && (x3==1 || x3==3) ||
		   x1==3 && (x2==1 || x2==2) && (x3==1 || x3==2)) {
			return true;
		}else if(x1==4 && (x2==5 || x2==6) && (x3==5 || x3==6) || 
				 x1==5 && (x2==4 || x2==6) && (x3==4 || x3==6) ||
				 x1==6 && (x2==4 || x2==5) && (x3==4 || x3==5)) {
			return true;
		}else if(x1==7 && (x2==8 || x2==9) && (x3==8 || x3==9) || 
				 x1==8 && (x2==7 || x2==9) && (x3==7 || x3==9) ||
				 x1==9 && (x2==7 || x2==8) && (x3==7 || x3==8)) {
			return true;
		}else if(x1==1 && (x2==4 || x2==7) && (x3==4 || x3==7) || 
				 x1==4 && (x2==1 || x2==7) && (x3==1 || x3==7) ||
				 x1==7 && (x2==1 || x2==4) && (x3==1 || x3==4)) {
			return true;
		}else if(x1==2 && (x2==5 || x2==8) && (x3==5 || x3==8) || 
				 x1==5 && (x2==2 || x2==8) && (x3==2 || x3==8) ||
				 x1==8 && (x2==2 || x2==5) && (x3==2 || x3==5)) {
			return true;
		}else if(x1==3 && (x2==6 || x2==9) && (x3==6 || x3==9) || 
				 x1==6 && (x2==3 || x2==9) && (x3==3 || x3==9) ||
				 x1==9 && (x2==3 || x2==6) && (x3==3 || x3==6)) {
			return true;
		}else if(x1==1 && (x2==5 || x2==9) && (x3==5 || x3==9) || 
				 x1==5 && (x2==1 || x2==9) && (x3==1 || x3==9) ||
				 x1==9 && (x2==1 || x2==5) && (x3==1 || x3==5)) {
			return true;
		}else if(x1==3 && (x2==5 || x2==7) && (x3==5 || x3==7) || 
				 x1==5 && (x2==3 || x2==7) && (x3==3 || x3==7) ||
				 x1==7 && (x2==3 || x2==5) && (x3==3 || x3==5)) {
			return true;
		}
		return false;
	}
	public static boolean ganaUsuario() {
		if(o1==1 && (o2==2 || o2==3) && (o3==2 || o3==3) || 
		   o1==2 && (o2==1 || o2==3) && (o3==1 || o3==3) ||
		   o1==3 && (o2==1 || o2==2) && (o3==1 || o3==2)) {
			return true;
		}else if(o1==4 && (o2==5 || o2==6) && (o3==5 || o3==6) || 
				 o1==5 && (o2==4 || o2==6) && (o3==4 || o3==6) ||
				 o1==6 && (o2==4 || o2==5) && (o3==4 || o3==5)) {
			return true;
		}else if(o1==7 && (o2==8 || o2==9) && (o3==8 || o3==9) || 
				 o1==8 && (o2==7 || o2==9) && (o3==7 || o3==9) ||
				 o1==9 && (o2==7 || o2==8) && (o3==7 || o3==8)) {
			return true;
		}else if(o1==1 && (o2==4 || o2==7) && (o3==4 || o3==7) || 
				 o1==4 && (o2==1 || o2==7) && (o3==1 || o3==7) ||
				 o1==7 && (o2==1 || o2==4) && (o3==1 || o3==4)) {
			return true;
		}else if(o1==2 && (o2==5 || o2==8) && (o3==5 || o3==8) || 
				 o1==5 && (o2==2 || o2==8) && (o3==2 || o3==8) ||
				 o1==8 && (o2==2 || o2==5) && (o3==2 || o3==5)) {
			return true;
		}else if(o1==3 && (o2==6 || o2==9) && (o3==6 || o3==9) || 
				 o1==6 && (o2==3 || o2==9) && (o3==3 || o3==9) ||
				 o1==9 && (o2==3 || o2==6) && (o3==3 || o3==6)) {
			return true;
		}else if(o1==1 && (o2==5 || o2==9) && (o3==5 || o3==9) || 
				 o1==5 && (o2==1 || o2==9) && (o3==1 || o3==9) ||
				 o1==9 && (o2==1 || o2==5) && (o3==1 || o3==5)) {
			return true;
		}else if(o1==3 && (o2==5 || o2==7) && (o3==5 || o3==7) || 
				 o1==5 && (o2==3 || o2==7) && (o3==3 || o3==7) ||
			 	 o1==7 && (o2==3 || o2==5) && (o3==3 || o3==5)) {
			return true;
		}
		return false;
	}

}
