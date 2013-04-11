package racetrack

class Race { 
	String name
	Date startDate
	String city
	String state
	BigDecimal distance
	BigDecimal cost
	Integer maxRunners = 100000
	
	static hasMany = [registrations:Registration]
	
	String toString(){
		return "${name},${startDate.format('MM/dd/yyyy')}"
	}
	
    static constraints = {
		startDate(validator:{return (it < new Date())})
		
    }
}
