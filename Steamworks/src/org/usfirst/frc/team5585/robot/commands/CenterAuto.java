package org.usfirst.frc.team5585.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *command group to score on the center gear peg.
 */
public class CenterAuto extends CommandGroup {
    
    public  CenterAuto() {
        // Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.
    	
        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    	addSequential(new score_forward());
    	addSequential(new score_reverse());
    }
}
