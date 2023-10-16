// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.HockeyControl;
import frc.robot.subsystems.HockeySubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;


public class RobotContainer {

  private final HockeySubsystem m_hockey = new HockeySubsystem();

  private final HockeyControl hockey = new HockeyControl(m_hockey);


  public RobotContainer() {
    m_hockey.setDefaultCommand(hockey);
    configureBindings();
  }

  private void configureBindings() {
  }

  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return null;
  }
}
