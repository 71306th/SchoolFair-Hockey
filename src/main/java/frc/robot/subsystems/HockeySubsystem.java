// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class HockeySubsystem extends SubsystemBase {

  private final WPI_TalonSRX p1horizontal;
  private final WPI_TalonSRX p2horizontal;

  private final CANSparkMax p1vertical;
  private final CANSparkMax p2vertical;

  public HockeySubsystem() {
    p1horizontal = new WPI_TalonSRX(Constants.HockeyConstants.player1horizontal);
    p2horizontal = new WPI_TalonSRX(Constants.HockeyConstants.player2horizontal);

    p1vertical = new CANSparkMax(Constants.HockeyConstants.player1vertical, MotorType.kBrushless);
    p2vertical = new CANSparkMax(Constants.HockeyConstants.player2vertical, MotorType.kBrushless);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  public void P1Hori(double speed){
    p1horizontal.set(speed*Constants.HockeyConstants.player1horizontalregulator);
  }

  public void P2Hori(double speed){
    p2horizontal.set(speed*Constants.HockeyConstants.player2horizontalregulator);
  }

  public void P1Verti(double speed){
    p1vertical.set(speed*Constants.HockeyConstants.player1verticalregulator);
  }

  public void P2Verti(double speed){
    p2vertical.set(speed*Constants.HockeyConstants.player2verticalregulator);
  }
}
