package frc.robot.subsystems.Manager;

import org.team7525.subsystem.Subsystem;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.subsystems.Algaer.Algaer;
import frc.robot.subsystems.SwerveSubsystem.DriveStates;
import frc.robot.subsystems.SwerveSubsystem.SwerveSubsystem;





public class Manager extends Subsystem<ManagerStates> {
    private final XboxController controller = new XboxController(0);
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

            addRunnableTrigger(() ->  algaer.setState(DriveStates.DRIVE_FAST), () -> driverController.getYButton());
            addRunnableTrigger(() ->  algaer.setState(DriveStates.DRIVE_SLOW), () -> driverController.getXButton());
            
     


}
        public static void runAllPeriodic() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'runAllPeriodic'");
        }
        @Override
        protected void runState() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'runState'");
        }
    }


    
