package boardgameproject;



public class Window {
    static final int XBORDER = 150;
    static final int YBORDER = 150;
    static final int YTITLE = 25;
    static final int WINDOW_WIDTH = 1200;
    static final int WINDOW_HEIGHT = 865;    
    
    static int xsize = -1;
    static int ysize = -1;
    
    static public int getX(int x) {
        return (x + XBORDER);
    }

    static public int getY(int y) {
        return (y + YBORDER + YTITLE);
    }
    static public int getYNormal(int y) {
        return (-y + YBORDER + YTITLE+getHeight2());
    }

    static public int getWidth2() {
        return (xsize - getX(0) - XBORDER);
    }

    static public int getHeight2() {
        return (ysize - getY(0) - YBORDER);
    }
    
}
