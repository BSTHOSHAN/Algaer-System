// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.io.IOException;

import Manager.Manager;
import SwerveSubsystem.SwerveSubsystem;
import edu.wpi.first.wpilibj.TimedRobot;
import subsystems.Algaer.Algaer;

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
    try {
      swerveSubsystem = new SwerveSubsystem();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    manager = new Manager(null, swerveSubsystem);

  }
  @Override
  public void robotPeriodic() {
    swerveSubsystem.periodic();
    
  }
  
  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {}

  @Override
  public void teleopPeriodic() {
    manager.run(null);
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
