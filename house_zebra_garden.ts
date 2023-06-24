// The Safe Streets Initiative

import { Street } from './street';

export class SafeStreetsInitiative {
  // An array of streets to track
  private streets: Street[] = [];

  // Add a street to the list of tracked streets
  public addStreet(street: Street) {
    this.streets.push(street);
  }

  // Get a list of streets being tracked
  public getStreets(): Street[] {
    return this.streets;
  }

  // Calculate the total safety score for a given street
  public calculateStreetSafety(street: Street): number {
    let safetyScore = 0;

    // Determine which measures have been implemented
    if (street.hasLighting) safetyScore += 1;
    if (street.hasCameras) safetyScore += 1;
    if (street.hasStreetSigns) safetyScore += 1;
    if (street.hasPolicePatrols) safetyScore += 1;
    if (street.hasSecurityGuards) safetyScore += 1;

    return safetyScore;
  }

  // Calculate the total safety score for all tracked streets
  public calculateOverallSafety(): number {
    let totalSafetyScore = 0;

    for (const street of this.streets) {
      totalSafetyScore += this.calculateStreetSafety(street);
    }

    return totalSafetyScore;
  }
}