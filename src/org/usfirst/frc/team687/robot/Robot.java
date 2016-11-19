
package org.usfirst.frc.team687.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	Encoder encode;
	CANTalon talon;
	ClosedLoopControl clc;
	Joystick joy;
    public void robotInit() {
    	joy = new Joystick(2);
    	encode = new Encoder(8,9);
    	encode.reset();
    	talon = new CANTalon(0);
    	clc = new ClosedLoopControl(Constants.kP,Constants.kI, Constants.desiredTicks);
    	SmartDashboard.putNumber("kP", Constants.kP);
    	SmartDashboard.putNumber("kI", Constants.kI);
    	SmartDashboard.putNumber("desiredTicks", Constants.desiredTicks);
    }
    
    public void autonomousInit() {

    }

    public void autonomousPeriodic() {

    }
    public void teleopPeriodic() {
		System.out.println("Running Teleop");
	    Constants.kP = SmartDashboard.getNumber("kP");
	    Constants.kI = SmartDashboard.getNumber("kI");
	    Constants.desiredTicks = SmartDashboard.getNumber("desiredTicks");
    	if(joy.getRawButton(6)){
    		SmartDashboard.putBoolean("pressed", true);
        	talon.set(clc.get(encode.getRaw()));    		
    	}
    	else{
    		SmartDashboard.putBoolean("pressed", false);
    		talon.set(0);
    	}
    	
    }
    public void testPeriodic() {
    
    }
    
}
