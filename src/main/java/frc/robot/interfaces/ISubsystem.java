package frc.robot.interfaces;

import frc.robot.models.LogDataBE;

// this is the iterface that all Beak Squad Subsystems must implement
public interface ISubsystem
{
    // this method optionally adds any data to be logged
    public void updateLogData(LogDataBE logData);
    
    // this method optionally writes data to the dashboard
	public void updateDashboard();
}