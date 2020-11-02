package edu.umb.cs681.hw04;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class NFL {

	private String team;
	private int matchesPlayed;
	private int won;
	private int lost;
	private int points;
	private double winper;

	public NFL(String team, int matchesPlayed, int won, int lost, int points, double winper) {
		this.team = team;
		this.matchesPlayed = matchesPlayed;
		this.won = won;
		this.lost = lost;
		this.points = points;
		this.winper = winper;
	}

	public String getTeam() {
		return team;
	}

	public int getMatchesPlayed() {
		return matchesPlayed;
	}

	public int getWon() {
		return won;
	}

	public int getLost() {
		return lost;
	}

	public int getPoints() {
		return points;
	}

	public double getwinper() {
		return winper;
	}

	public static void main(String args[]) {
		ArrayList<NFL> NFLTable = new ArrayList<>();

		NFLTable.add(new NFL("New England Patriots", 4, 3, 1, 49, +0.131));
		NFLTable.add(new NFL("Atanta Falcons", 4, 2, 2, 36, +0.577));
		NFLTable.add(new NFL("Dallas Cowboys", 4, 2, 2, 11, +0.607));
		NFLTable.add(new NFL("Philadelphia Eagles", 4, 3, 1, 21, +0.877));

		long numberOfTeams = NFLTable.stream().count();
		System.out.println("Number of teams in NFL: " + numberOfTeams);

		NFL highestRunRateTeam = NFLTable.stream().max(Comparator.comparing(NFL::getwinper)).get();
		System.out.println("NFL Team that has highest Win Percentage : " + highestRunRateTeam.getTeam());

		NFL leastPointsTeam = NFLTable.stream().min(Comparator.comparing(NFL::getPoints)).get();
		System.out.println("Team that has least points: " + leastPointsTeam.getTeam());

		List<NFL> sortedBywinper = NFLTable.stream().sorted(Comparator.comparing(NFL::getwinper, Comparator.reverseOrder()))
				.collect(Collectors.toList());
		System.out.println("Teams sorted by Win Percentage: ");
		sortedBywinper.forEach((NFL NFL) -> System.out.println(NFL.getTeam() + ": " + NFL.getwinper()));

	}
}