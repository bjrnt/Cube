import static org.junit.Assert.*;

import org.junit.Test;
import org.lwjgl.Sys;


public class Matrix3x3Test {
	private Matrix3x3 m,m2,I,product1,product2;
	@Test
	public void testMatrix3x3Vector3DVector3DVector3D() {
		m=new Matrix3x3(new Vector3D(1, 2, 3), new Vector3D(4, 5, 6), new Vector3D(7, 8, 9));
//		System.out.println("m=\n"+m);
		m2=new Matrix3x3(9, 8, 7, 6, 5, 4, 3, 2, 1);
//		System.out.println();
//		System.out.println("m2=\n"+m2);
		I=new Matrix3x3(1,0,0,0,1,0,0,0,1);
		product1=Matrix3x3.multiply(m2, m);
		
//		System.out.println();
//		System.out.println("I=\n"+I);
		
//		System.out.println("\nm2*m=");
//		System.out.println(product1);
		product2=Matrix3x3.multiply(m, product1);
		product2=Matrix3x3.multiply(product2, m2);
//		System.out.println("\nm*m2*m*m2=\n"+product2);
		
//		System.out.println("\nm*m2*m*m2=\n"+Matrix3x3.multiplyMany(new Matrix3x3[]{m,m2,m,m2}));
	}
	@Test
	public void testConversion(){
		m=new Matrix3x3(1,0,0,0,1,0,0,0,1);
		Vector3D v=new Vector3D(1, 2, 3);
		System.out.println(m.translateVector(v));
	}
	

}
