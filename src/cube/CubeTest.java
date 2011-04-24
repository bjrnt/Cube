package cube;
import java.util.ArrayList;
import objectTypes.Vector3D;
import org.junit.Test;


public class CubeTest {
	Cube c=new Cube(3);

	@Test
	public void testGetGrid() {
		ArrayList<Vector3D[]> grid=c.getGrid(null);//Will not work
		for (int i = 0; i < grid.size(); i++) {
			System.out.println(grid.get(i)[0]+","+grid.get(i)[1]);
		}
	}

}
