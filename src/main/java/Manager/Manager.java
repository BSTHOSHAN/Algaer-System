package Manager;

import org.team7525.subsystem.Subsystem;

import SwerveSubsystem.SwerveSubsystem;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import subsystems.Algaer.Algaer;





public class Manager extends Subsystem<ManagerStates> {
    private final XboxController controller = new XboxController(0);
    private final Algaer alger = new Algaer();
        private Algaer algaer;
        private final SwerveSubsystem swerve;
        private final XboxController driverController = new XboxController(0);

        public Manager(Algaer algaer, SwerveSubsystem swerve) {
            super("manager", ManagerStates.IDLE);  
            this.algaer = algaer;
            this.swerve = swerve;

            addRunnableTrigger(() -> algaer.setState(ManagerStates.INTAKING), () -> controller.getAButton());
            addRunnableTrigger(() -> algaer.setState(ManagerStates.SHOOTING), () -> controller.getBButton());
            addRunnableTrigger(() -> algaer.setState(ManagerStates.IDLE),     () -> controller.getXButton());

            addRunnableTrigger(() ->  algaer.setState(ManagerStates.DRIVE_FAST), () -> driverController.getYButton());
            addRunnableTrigger(() ->  algaer.setState(ManagerStates.DRIVE_SLOW), () -> driverController.getXButton());
            
     


}
        @Override
        protected void runState() {
            switch (getState()) {
                case DRIVE_FAST:
                    swerve.drive(1.0, 0, 0, true); // Full speed forward
                    break;
                case DRIVE_SLOW:
                    swerve.drive(0.3, 0, 0, true); // Slow forward
                    break;
                default:
                    swerve.drive(0, 0, 0, true);   // Stop
            }
        }

        public static void runAllPeriodic() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'runAllPeriodic'");
        }
    }


    
