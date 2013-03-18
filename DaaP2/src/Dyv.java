
public class Dyv {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] entrada=new int[6];
		entrada[0]=23475;
		entrada[1]=87223;
		entrada[2]=78736;
		entrada[3]=37;
		entrada[4]=137;
		entrada[5]=237;
		boolean[] sol=digitosComunesDYV(entrada,0,entrada.length-1);
	//	boolean[] sol=digitosComunesITE(entrada);
		for(int i=0;i<sol.length;i++){
			System.out.print("   "+i+"->");
			if(sol[i]){
				System.out.print("true");
			}else{
				System.out.print("false");
			}
		}
		
	}
	
	
	public static boolean[] digitosComunesDYV( int[] v, int ini, int fin ){
		
		if(ini==fin){
			boolean[] sol=new boolean[10];
			for(int i=0;i<sol.length;i++){
				sol[i]=false;
			}
			int aux=v[ini];
			
			while(aux>0){
				sol[aux%10]=true;
				aux/=10;
			}
														
			return sol;
		}else{
			int corte=(ini+fin)/2;
			boolean[] par1=new boolean[10];
			par1=digitosComunesDYV(v,ini,corte);
														
			boolean[] par2=new boolean[10];
			par2=digitosComunesDYV(v,corte+1,fin);
														
			boolean[] sol=new boolean[10];
			for(int i=0;i<par1.length;i++){
				sol[i]=(par1[i]&par2[i]);
			}
			
			return sol;
 		}
		
		
		
	}
	
	public static boolean[] digitosComunesITE( int[] v ){
	
		boolean[] sol=new boolean[10];
		for(int i=0;i<sol.length;i++){
			sol[i]=true;
		}
		int aux;
		for(int i=0;i<sol.length;i++){
			for(int j=0;j<v.length;j++){
				aux=v[j];
				while(aux>9 && aux%10!=i){
					aux/=10;
				}
				if(aux%10!=i){
					sol[i]=false;
				}
			}
		}
		
		
		return sol;
	}
	
	
	
	
	
	

}
