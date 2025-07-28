package SwerveSubsystem;

import java.io.File;
import java.io.IOException;

import edu.wpi.first.wpilibj.Filesystem;
import swervelib.parser.SwerveParser;
import swervelib.SwerveDrive;
import edu.wpi.first.math.util.Units;

public class SwerveSubsystem {
    private final SwerveDrive swerveDrive;

    public SwerveSubsystem() throws IOException {
        File directory = new File(Filesystem.getDeployDirectory(), "swerve");
        double maxSpeed = Units.feetToMeters(4.5); // your top speed
        swerveDrive = new SwerveParser(directory)
            .createSwerveDrive(maxSpeed);
    }

    public void periodic() {
        swerveDrive.updateOdometry();
    }

    // Example drive command method
    public void drive(double x, double y, double rot, boolean fieldRelative) {
        swerveDrive.drive(
            new edu.wpi.first.math.geometry.Translation2d(x, y),
            rot,
            fieldRelative,
            false
        );
    }
}
