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
        
        if (y > 0) {
            return true;
        }
        
        return false;
        
    }
    
    private boolean isEstAvanceOk(int x, int y) {
        
        checkLimit(x, y);
        
        if (x < maxX) {
            return true;
        }
        
        return false;
        
    }
    
    private boolean isNordAvanceOk(int x, int y) {
        
        checkLimit(x, y);
        
        if (y < maxY) {
            return true;
        }
        
        return false;
        
    }
    
    private boolean isOuestAvanceOk(int x, int y) {
        
        checkLimit(x, y);
        
        if (x > 0) {
            return true;
        }
        
        return false;
        
    }
    
    private boolean checkLimit(int x, int y) {
        if (x > maxX || y > maxY || x < 0 || y < 0) {
            return false;
        }
        return true;
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
    
    public void AvancePoint(TendeusePoint point, List<OrientationPivot> orientationPivots) {
        
        TendeusePoint locPoint = point;
        
        orientationPivots.stream().forEach(unOrientationPivot -> {
            
            System.out
                .println(locPoint + " next OrientationPivot " + unOrientationPivot.toString());
            
            if (unOrientationPivot.equals(OrientationPivot.A)) {
                
                switch (locPoint.getOrientation()) {
                    case N:
                        if (isNordAvanceOk(locPoint.getX(), locPoint.getY())) {
                            locPoint.AvanceY();
                        }
                        break;
                    case E:
                        if (isEstAvanceOk(locPoint.getX(), locPoint.getY())) {
                            locPoint.AvanceX();
                        }
                        break;
                    case S:
                        if (isSudAvanceOk(locPoint.getX(), locPoint.getY())) {
                            locPoint.ReturneY();
                        }
                        break;
                    case W:
                        if (isOuestAvanceOk(locPoint.getX(), locPoint.getY())) {
                            locPoint.ReturneX();
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
