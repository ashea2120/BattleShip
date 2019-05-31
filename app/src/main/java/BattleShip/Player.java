package team2.BattleShip;

import java.util.ArrayList;
import java.util.List;


public class Player {
    private int numShipsArranged = 0;
    private int numShips = 3;
    private int playerNum;
    private List<team2.BattleShip.Ship> ships = new ArrayList<>(numShips);

    /**
     * fleet:
     * - little guy: occupies 2 cells, has 1 attack initially
     * - middle man: 3, 2
     * - big boy: 5, 3
     * each upgrade increments attack count of each (alive) ship
     */
    public Player(int playerNum) {
        this.playerNum = playerNum;

        team2.BattleShip.Ship ship = new team2.BattleShip.Ship(playerNum, team2.BattleShip.Ship.ShipType.LITTLE_GUY);
        ships.add(ship);
        ship = new team2.BattleShip.Ship(playerNum, team2.BattleShip.Ship.ShipType.MIDDLE_MAN);
        ships.add(ship);
        ship = new team2.BattleShip.Ship(playerNum, team2.BattleShip.Ship.ShipType.BIG_BOY);
        ships.add(ship);
    }

    public int getNumShipsArranged() {
        return numShipsArranged;
    }

    public int getNumShips() {
        return numShips;
    }

    public List<team2.BattleShip.Ship> getShips() {
        return ships;
    }

    private int getNumShipsToArrange() {
        return numShips - numShipsArranged;
    }

    public boolean canAddCell() {
        return getNumShipsToArrange() > 0;
    }

    /**
     * add cell to the ship being arranged
     */
    public void addCell(team2.BattleShip.Cell cell) {
        team2.BattleShip.Ship ship = ships.get(numShipsArranged);

        ship.addCell(cell);
        if (!ship.canAddCells())
            numShipsArranged++;
    }

    /**
     * @return 1 alive ship didn't finish attacking
     */
    public boolean canAttack() {
        for (team2.BattleShip.Ship ship : ships)
            if (ship.canAttack())
                return true;
        return false;
    }

    /**
     * let attacking ship attack tapped cell
     */
    public void attackCell(team2.BattleShip.Cell cell) {
        team2.BattleShip.Ship ship = getNextShipCanAttack();
        ship.attackCell(cell);
    }

    /**
     * @return next attack will be made by which ship?
     */
    public team2.BattleShip.Ship getNextShipCanAttack() {
        int index = 0;
        team2.BattleShip.Ship ship;
        do {
            ship = ships.get(index);
            index++;
        } while (!ship.canAttack());
        return ship;
    }

    /**
     * upgrade fleet
     */
    public void upgrade() {
        for (team2.BattleShip.Ship ship : ships)
            ship.upgrade();
    }

    /**
     * after done attacking
     */
    public void resetNumsAttacksMade() {
        for (team2.BattleShip.Ship ship : ships)
            ship.setNumAttacksMade(0);
    }

    /**
     * @return how many ships in fleet are still alive?
     */
    public int getNumShipsAlive() {
        int numShipsAlive = 0;
        for (team2.BattleShip.Ship ship : ships)
            if (ship.isAlive())
                numShipsAlive++;
        return numShipsAlive;
    }

    /**
     * @return >= 1 ship still alive
     */
    public boolean isAlive() {
        return getNumShipsAlive() > 0;
    }
}
