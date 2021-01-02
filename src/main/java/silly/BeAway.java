package silly;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

import javax.swing.JOptionPane;

public class BeAway {

    private Timer timer;
    private Robot robot;

    public static void main(String[] args) {
        new BeAway();
    }

    public BeAway() {
        try {
            timer = new Timer();
            robot = new Robot();
            execute();
        } catch (Exception e) {
            System.out.println("Error! "+e.getMessage());
        }
    }

    private void execute() {
        System.out.println("--------START---------");
        Integer option = 0;
        boolean isFirstTime = true;
        while (option == 0) {
            option = JOptionPane.showConfirmDialog(null, "Yes to Start\n Cancel to Stop", "Be Awake",JOptionPane.CANCEL_OPTION);
            if (isFirstTime && option == 0) {
                timer.scheduleAtFixedRate(new ViewActions(robot), startDelayExecution(5), timeDelayExecution(1));
                isFirstTime = false;
            }
        }
        timer.cancel();
        System.out.println("--------ENDED---------");
    }

    private static long startDelayExecution(long seconds) {
        return TimeUnit.SECONDS.toMillis(seconds);
    }
    
    private static long timeDelayExecution(long minutes) {
    	return TimeUnit.MINUTES.toMillis(minutes);
    }

    private class ViewActions extends TimerTask {
        private Robot robot;

        public ViewActions(Robot robot) {
                this.robot = robot;
        }

        @Override
        public void run() {
            System.out.println("[Executing] - Moving mouse");
            moveMouseZ();
            System.out.println("[Executing] - Alterning tab");
            altTabWindows();
            System.out.println("DONE!");    
        }

        private void moveMouseZ() {
            MousePosition position = new MousePosition();
            position.setPosX(300);
            position.setPosY(300);

            List<BiFunction<Integer, MousePosition, MousePosition>> sequenceList = new ArrayList<>();
            sequenceList.add(this::moveMouseSide);
            sequenceList.add(this::moveMouseDiagonal);
            sequenceList.add(this::moveMouseSide);
            sequenceList.forEach(function -> doAction(position, function));
        }
        
        private void doAction(MousePosition position, BiFunction<Integer, MousePosition, MousePosition> function) {
        	position.addNewPosition(doMoveMouse(position, function));
        }
        
        private MousePosition doMoveMouse(MousePosition positionInicial, BiFunction<Integer, MousePosition, MousePosition> function) {
        	MousePosition position = new MousePosition();
        	IntStream.range(0, 300).forEach(index -> position.addNewPosition(function.apply(index, positionInicial)));
        	return position;
        }

        private MousePosition moveMouseSide(int index, MousePosition positionInitial) {
        	MousePosition position = MousePosition.copy(positionInitial);
        	position.setPosX(positionInitial.getPosX() + (index * 2));
            moveMousePosition(position);
            return position;
        }

        private MousePosition moveMouseDiagonal(int index, MousePosition positionInitial) {
        	MousePosition position = MousePosition.copy(positionInitial);
            position.setPosX(positionInitial.getPosX() - (index * 2));
            position.setPosY(positionInitial.getPosY() + index);
            moveMousePosition(position);
            return position;
        }

        private void moveMousePosition(MousePosition pos) {
            robot.mouseMove(pos.getPosX(), pos.getPosY());
            robot.delay(5);
        }

		private void altTabWindows() {
			IntStream.range(0, 5).forEach(this::doAltTab);
		}

        private void doAltTab(int index) {
            robot.delay(500);
            doTabs(2);
            robot.delay(5000);
            doTabs(4);
            robot.delay(5000);
        }

        private void doTabs(int count) {
            robot.keyPress(KeyEvent.VK_ALT);
            IntStream.range(0, count).forEach(this::doSingleTab);
            robot.keyRelease(KeyEvent.VK_ALT);
        }

        private void doSingleTab(int index) {
            robot.delay(200);
            robot.keyPress(KeyEvent.VK_TAB);
            robot.delay(200);
            robot.keyRelease(KeyEvent.VK_TAB);
        }
    }

    private static class MousePosition {
        private int posX;
        private int posY;
        public MousePosition() {
		}
        private MousePosition(MousePosition newPosition) {
        	this.posX = newPosition.getPosX();
        	this.posY = newPosition.getPosY();
		}
		public static MousePosition copy(MousePosition newPosition) {
        	return new MousePosition(newPosition);
		}
        public void addNewPosition(MousePosition newPosition) {
        	this.posX = newPosition.getPosX();
        	this.posY = newPosition.getPosY();
		}
        public int getPosX() {
            return posX;
        }
        public void setPosX(int posX) {
            this.posX = posX;
        }
        public int getPosY() {
            return posY;
        }
        public void setPosY(int posY) {
            this.posY = posY;
        }
        @Override
        public String toString() {
        	return "PosX [" + this.posX + "] - PosY [" + this.posY + "]";
        }
    }

}