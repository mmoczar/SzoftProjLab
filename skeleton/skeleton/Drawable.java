import java.io.IOException;
import javafx.scene.shape.Rectangle;

public abstract class Drawable extends Rectangle {
	public Drawable(int i, int j, int k, int l) {
		super(i,j,k,l);
	}

	public abstract void draw() throws IOException;
	
	public boolean getisDead() {
		return false;
	}

	public boolean getAlive() {
		return true;
	}
}
