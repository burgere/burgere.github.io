#Eric Burger
#IT 212
#Due 10/2/2013
#Implement and test Card and Deck classes

#Card class
class Card
  attr_accessor :rank, :suit
  attr_reader :symbol
  #initialize method
  def initialize(the_rank, the_suit)
    @rank = the_rank
    @suit = the_suit
    @symbol = [nil, nil, '2', '3', '4', '5', '6', '7', '8', '9', '10', 'J', 'Q', 'K', 'A']
  end
    
  def to_s
    return @symbol[@rank] + @suit
  end
  
end

#Deck class
class Deck
				
  def initialize
    @cards = []
      for suit in ['C', 'D', 'H', 'S']
        for rank in 2..14
        				@cards << Card.new(rank, suit)
        end
  	end
	end


#Methods
#Deal from the deck 
	def deal
	    return @cards.pop
  end

  def add_to_bottom(card)
    @cards.insert(0, card)
  end
  

  def add_to_top(card)
    @cards.push(card)
  end


  def count
  	@cards.count
  end

  def is_empty
    return @cards.empty?
  end
  
  def shuffle
    @cards.shuffle!
  end

  def to_s
    out = ""
    for i in @cards
      out += i.to_s
      out << " "
    end
    return out
	end

end
