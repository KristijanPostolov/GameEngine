package core.rendering;

public enum RenderingLayer {

    BACKGROUND(1),
    DEFAULT(2),
    FOREGROUND(3),
    GUI(4);


    public final int sortingLayer;

    RenderingLayer(int sortingLayer) {
        this.sortingLayer = sortingLayer;
    }

}
