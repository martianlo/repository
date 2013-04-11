package racetrack

class Registration {
	Date dateCreated //Note: this is a special name
	Boolean paid
	Race race
	Runner runner
	
	static belongsTo = [race:Race, runner:Runner]
	
    static constraints = {
		race()
		runner()
		paid()
		dateCreated()
    }
}
