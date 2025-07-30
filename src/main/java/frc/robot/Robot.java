// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.io.IOException;

import edu.wpi.first.wpilibj.TimedRobot;
import frc.robot.subsystems.Algaer.Algaer;
import frc.robot.subsystems.Manager.Manager;
import frc.robot.subsystems.SwerveSubsystem.SwerveSubsystem;

/**
 * The methods in this class are called automatically corresponding to each mode, as described in
 * the TimedRobot documentation. If you change the name of this class or the package after creating
 * this project, you must also update the Main.java file in the project.
 */

public class Robot extends TimedRobot {
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  
  private SwerveSubsystem swerveSubsystem;
  private Manager manager;
  
  
  @Override
  public void robotInit() {
    swerveSubsystem = new SwerveSubsystem();
    manager = new Manager(new Algaer(), swerveSubsystem);

  }
  @Override
  public void robotPeriodic() {
    swerveSubsystem.periodic();
    manager.periodic();
  }
  
  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    manager.periodic();
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void testInit() {}

  @Override
  public void testPeriodic() {}

  @Override
  public void simulationInit() {}

  @Override
  public void simulationPeriodic() {}
}
