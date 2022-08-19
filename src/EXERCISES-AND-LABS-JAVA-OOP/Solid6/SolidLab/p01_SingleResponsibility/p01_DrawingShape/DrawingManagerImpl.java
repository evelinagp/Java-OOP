package SolidLab.p01_SingleResponsibility.p01_DrawingShape;

import SolidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.DrawingManager;
import SolidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.DrawingRepository;
import SolidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Renderer;
import SolidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.Shape;


public class DrawingManagerImpl implements DrawingManager {

    private final DrawingRepository drawingRepository;
    private final Renderer renderer;

    public DrawingManagerImpl(DrawingRepository drawingRepository, Renderer renderer) {
        this.drawingRepository = drawingRepository;
        this.renderer = renderer;
    }


    @Override
    public void draw(Shape shape) {
        renderer.render(drawingRepository,shape);
    }
}
