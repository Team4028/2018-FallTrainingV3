package frc.robot.models; 

/**
 * A drivetrain command consisting of the left, right motor settings and whether
 * the brake mode is enabled.
 */
public class DriveCmdBE 
{
	protected double mLeftMotor;
	protected double mRightMotor;
	protected boolean mBrakeMode;

    public DriveCmdBE(double left, double right) 
    {
		this(left, right, false);
	}

    public DriveCmdBE(double left, double right, boolean brakeMode) 
    {
		mLeftMotor = left;
		mRightMotor = right;
		mBrakeMode = brakeMode;
	}

	public static DriveCmdBE NEUTRAL = new DriveCmdBE(0, 0);
	public static DriveCmdBE BRAKE = new DriveCmdBE(0, 0, true);

    public double getLeft() 
    {
		return mLeftMotor;
	}

    public double getRight() 
    {
		return mRightMotor;
	}

    public boolean getBrakeMode() 
    {
		return mBrakeMode;
	}

	@Override
    public String toString() 
    {
		return "L: " + mLeftMotor + ", R: " + mRightMotor + (mBrakeMode ? ", BRAKE" : "");
	}
}