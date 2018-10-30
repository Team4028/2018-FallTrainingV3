package frc.robot;

import java.lang.Package;

public class ManifestTest {
  public static void main(String[] args) {
    Package p = ManifestTest.class.getPackage();
    String implementationVersion = p.getImplementationVersion();
    System.out.println("Package Implementation-Version: " + implementationVersion);
  }
}