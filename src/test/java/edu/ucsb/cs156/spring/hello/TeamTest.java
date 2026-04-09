package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }
    @Test
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }

    @Test
    public void equals_same_object_returns_correct() {
        Team test = team;
        assertEquals(team==test, team.equals(test));
    }

    @Test
    public void equals_different_class_returns_correct() {
        String test = "not a team";
        assertEquals(false, team.equals(test));
    }
   
    @Test
    public void equals_equal_teams_returns_true() {
        Team team2 = new Team("test-team");
        assertEquals(true, team.equals(team2));
    }

    @Test
    public void equals_equal_teams_with_members_returns_true() {
        team.addMember("Alice");
        team.addMember("Bob");
        Team team2 = new Team("test-team");
        team2.addMember("Alice");
        team2.addMember("Bob");
        assertEquals(true, team.equals(team2));
    }

    @Test
    public void equals_different_names_returns_false() {
        Team team2 = new Team("different-team");
        assertEquals(false, team.equals(team2));
    }

    @Test
    public void equals_different_members_returns_false() {
        team.addMember("Alice");
        Team team2 = new Team("test-team");
        team2.addMember("Bob");
        assertEquals(false, team.equals(team2));
    }

    @Test
    public void equals_null_returns_false() {
        assertEquals(false, team.equals(null));
    }

    @Test 
    public void hashCode_equal_teams_returns_same_hash() {
        int result = team.hashCode();
        int expectedResult = -1226298695;
        assertEquals(expectedResult, result);
    }
}