import com.jme3.app.SimpleApplication;
import com.jme3.material.Material;
import com.jme3.math.ColorRGBA;
import com.jme3.math.Vector3f;
import com.jme3.scene.Geometry;
import com.jme3.scene.Node;
import com.jme3.scene.shape.Box;
import com.jme3.scene.shape.Sphere;
import com.jme3.input.KeyInput;
import com.jme3.input.controls.AnalogListener;
import com.jme3.input.controls.KeyTrigger;


public class HelloJME3 extends SimpleApplication {

    public static void main(String[] args){
        HelloJME3 app = new HelloJME3();
        app.start();
    }

    @Override
    public void simpleInitApp() {
        // Create root node for cube
        Node cubeNode = new Node("cubeNode");
        Box b = new Box(1, 1, 1); // create cube shape
        Geometry cubeGeom = new Geometry("Box", b);
        Material cubeMat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        cubeMat.setColor("Color", ColorRGBA.Blue);
        cubeGeom.setMaterial(cubeMat);
        cubeNode.attachChild(cubeGeom);
        cubeNode.setLocalTranslation(-2, 0, -5); // position the cube node
        
        // Create a sphere and its node
        Node sphereNode = new Node("sphereNode");
        Sphere s = new Sphere(32, 32, 1);
        Geometry sphereGeom = new Geometry("Sphere", s);
        Material sphereMat = new Material(assetManager, "Common/MatDefs/Misc/Unshaded.j3md");
        sphereMat.setColor("Color", ColorRGBA.Red);
        sphereGeom.setMaterial(sphereMat);
        sphereNode.attachChild(sphereGeom);
        sphereNode.setLocalTranslation(2, 0, -5); // position the sphere node
        
        // Attach both nodes to the rootNode
        rootNode.attachChild(cubeNode);
        rootNode.attachChild(sphereNode);
    // [previous code for setting up the scene]

    // Setting up key mappings
        inputManager.addMapping("ScaleUp", new KeyTrigger(KeyInput.KEY_U));
        inputManager.addMapping("ScaleDown", new KeyTrigger(KeyInput.KEY_J));
        inputManager.addMapping("Rotate", new KeyTrigger(KeyInput.KEY_R));

        inputManager.addListener(analogListener, "ScaleUp", "ScaleDown", "Rotate");
}

        private AnalogListener analogListener = new AnalogListener() {
            public void onAnalog(String name, float value, float tpf) {
                if (name.equals("ScaleUp")) {
                    cubeNode.scale(1.1f);
                } else if (name.equals("ScaleDown")) {
                    cubeNode.scale(0.9f);
                } else if (name.equals("Rotate")) {
                    sphereNode.rotate(0, 2*tpf, 0);
                }
            }
        };

        };