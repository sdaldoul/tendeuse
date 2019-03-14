package mow.it.now.core;

import java.util.List;

public class TendeuseServiceImpl implements TendeuseService {
    
    private int maxY;
    private int maxX;
    
    public TendeuseServiceImpl(int maxY, int maxX) {
        super();
        this.maxY = maxY;
        this.maxX = maxX;
    }
    
    public int getMaxY() {
        return maxY;
    }
    
    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }
    
    public int getMaxX() {
        return maxX;
    }
    
    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }
    
    private boolean isSudAvanceOk(int x, int y) {
        
        checkLimit(x, y);
        
        return (y > 0);
        
    }
    
    private boolean isEstAvanceOk(int x, int y) {
        
        checkLimit(x, y);
        
        return (x < maxX);
        
    }
    
    private boolean isNordAvanceOk(int x, int y) {
        
        checkLimit(x, y);
        
        return (y < maxY);
        
    }
    
    private boolean isOuestAvanceOk(int x, int y) {
        
        checkLimit(x, y);
        
        return (x > 0);
        
    }
    
    private boolean checkLimit(int x, int y) {
        return (x > maxX || y > maxY || x < 0 || y < 0);
    }
    
    private OrientationDirection avanceAvecOrientation(OrientationDirection orientationActual,
        OrientationPivot prochanieOrientationPivot) {
        
        OrientationDirection orientationToReturn = orientationActual;
        switch (orientationActual) {
            case N:
                if (prochanieOrientationPivot.equals(OrientationPivot.D)) {
                    orientationToReturn = OrientationDirection.E;
                } else if (prochanieOrientationPivot.equals(OrientationPivot.G)) {
                    orientationToReturn = OrientationDirection.W;
                }
                break;
            case E:
                if (prochanieOrientationPivot.equals(OrientationPivot.D)) {
                    orientationToReturn = OrientationDirection.S;
                } else if (prochanieOrientationPivot.equals(OrientationPivot.G)) {
                    orientationToReturn = OrientationDirection.N;
                }
                break;
            case S:
                if (prochanieOrientationPivot.equals(OrientationPivot.D)) {
                    orientationToReturn = OrientationDirection.W;
                } else if (prochanieOrientationPivot.equals(OrientationPivot.G)) {
                    orientationToReturn = OrientationDirection.E;
                }
                break;
            case W:
                if (prochanieOrientationPivot.equals(OrientationPivot.D)) {
                    orientationToReturn = OrientationDirection.N;
                } else if (prochanieOrientationPivot.equals(OrientationPivot.G)) {
                    orientationToReturn = OrientationDirection.S;
                }
                break;
            default:
                break;
        }
        
        return orientationToReturn;
        
    }
    
    public void avancePoint(TendeusePoint locPoint, List<OrientationPivot> orientationPivots) {
        
        // TODO add specific exception and control input
        
        if (locPoint != null && locPoint.getOrientation() != null && orientationPivots != null) {
            orientationPivots.stream().forEach(unOrientationPivot -> {
                
                System.out
                    .println(locPoint + " next OrientationPivot " + unOrientationPivot.toString());
                
                if (unOrientationPivot.equals(OrientationPivot.A)) {
                    
                    switch (locPoint.getOrientation()) {
                        case N:
                            if (isNordAvanceOk(locPoint.getX(), locPoint.getY())) {
                                locPoint.avanceY();
                            }
                            break;
                        case E:
                            if (isEstAvanceOk(locPoint.getX(), locPoint.getY())) {
                                locPoint.avanceX();
                            }
                            break;
                        case S:
                            if (isSudAvanceOk(locPoint.getX(), locPoint.getY())) {
                                locPoint.returneY();
                            }
                            break;
                        case W:
                            if (isOuestAvanceOk(locPoint.getX(), locPoint.getY())) {
                                locPoint.returneX();
                            }
                            break;
                        default:
                            break;
                    }
                    
                } else {
                    locPoint.setOrientation(
                        avanceAvecOrientation(locPoint.getOrientation(), unOrientationPivot));
                    
                }
            });
        }
        
    }
}
