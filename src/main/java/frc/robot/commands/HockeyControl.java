// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.HockeySubsystem;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;

/** An example command that uses an example subsystem. */
public class HockeyControl extends CommandBase {

  boolean P1SingleHanded = false;
  boolean P2SingleHanded = false;

  private final HockeySubsystem m_hockey;

  private final XboxController player1 = new XboxController(Constants.JoystickConstants.kPlayer1ControllerPort);
  private final XboxController player2 = new XboxController(Constants.JoystickConstants.kPlayer2ControllerPort);

  public HockeyControl(HockeySubsystem subsystem) {
    m_hockey = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_hockey);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_hockey.P1Hori(0);
    m_hockey.P2Hori(0);
    m_hockey.P1Verti(0);
    m_hockey.P2Verti(0);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(P1SingleHanded){
      m_hockey.P1Hori(player1.getRightY());
      m_hockey.P1Verti(player1.getRightX());
    }else{
      m_hockey.P1Hori(player1.getLeftY());
      m_hockey.P1Verti(player1.getRightX());
    }

    if(P2SingleHanded){
      m_hockey.P2Hori(player2.getRightY());
      m_hockey.P2Verti(player2.getRightX());
    }else{
      m_hockey.P2Hori(player2.getLeftY());
      m_hockey.P2Verti(player2.getRightX());
    }

    if(player1.getXButton()) P1SingleHanded = !P1SingleHanded;
    if(player2.getXButton()) P2SingleHanded = !P2SingleHanded;
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
