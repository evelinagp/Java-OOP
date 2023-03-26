package Solid6.SolidLab.p01_SingleResponsibility.p01_DrawingShape;

import Solid6.SolidLab.p01_SingleResponsibility.p01_DrawingShape.interfaces.*;


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
