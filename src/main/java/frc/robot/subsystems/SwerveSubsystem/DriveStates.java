package frc.robot.subsystems.SwerveSubsystem;

import org.team7525.subsystem.SubsystemStates;

public enum DriveStates implements SubsystemStates{
    DRIVE_FAST(1, 1.5),
    DRIVE_SLOW(1, 0.5),
    DRIVE_NORMAL(1, 1);


    double rotational;
    double trasnlational;

    private DriveStates(double rotational, double trasnlational) {
        this.rotational = rotational;
        this.trasnlational = trasnlational;
    } 

    public double getRotational() {
        return rotational;
    }
    public double getTrasnlational() {
        return trasnlational;
    }
}