#Eric Burger
#Project 5 - War Game
#Due 10/27/2013

require './proj3Burger.rb'

# DownStack class
class DownStack < Deck
  def initialize
    @cards = []
  end
  
  def to_s
    output = ""
    count = 1
    for card in @cards
      output += "#{card} ";
      if count % 13 == 0
        output += "\n"
      end
    count += 1
    end
  return output;
  end				
 end

#WarGame class
class WarGame
	attr_reader :num_plays
	
  def initialize
	  orig_deck = Deck.new
    @player_a = DownStack.new
    @player_b = DownStack.new
    @limbo_stack = DownStack.new
    @num_plays = 0
    for i in (1..7)
      orig_deck.shuffle
    end

    for x in (1..26)
      @player_a.add_to_bottom orig_deck.deal 
      @player_b.add_to_bottom orig_deck.deal
		end
  end
  
    
  def winner
  # Return the winner "a" or "b" if the game is over. (If @player_b.count == 0 
  #return "a"; else if @player_a.count == 0 return "b".)  If the game is not yet
  #over, return nil. 

    if @player_b.count == 0
      return "a"
    elsif @player_a.count == 0
      return "b"
    else
      return nil
    end
  end
  
  def play
  	if winner
  	  return
  	end
    @num_plays += 1
    pacard = @player_a.deal
    pbcard = @player_b.deal
    if pacard.rank > pbcard.rank
      @player_a.add_to_bottom(pacard)
      @player_a.add_to_bottom(pbcard)
      until @limbo_stack.is_empty
        @player_a.add_to_bottom @limbo_stack.deal
      end
    elsif pacard.rank < pbcard.rank
    	 @player_b.add_to_bottom(pacard)
    	 @player_b.add_to_bottom(pbcard)
    	 until @limbo_stack.is_empty
        @player_b.add_to_bottom @limbo_stack.deal
       end
    else
       @limbo_stack.add_to_bottom(pacard)
       @limbo_stack.add_to_bottom(pbcard)
       for i in 1..3
       		if winner
  	        return
  	      end		 
         @limbo_stack.add_to_bottom @player_a.deal
         @limbo_stack.add_to_bottom @player_b.deal
       end
    end
  end
  
  def finish_game
  #Repeatedly call the play method until there is a winner or until 5,000 plays 
  #have occurred, in which case there is a draw.
  	until winner || @num_plays >= 5000
  	  play
  	end
  end

  def to_s
  	deckCount = @player_a.count + @player_b.count + @limbo_stack.count
    return "Number of plays:%d\nPlayer A Count:%d\nPlayer A Deck:%s\nPlayer B Count:%d\nPlayer B Deck:%s\nLimbo Deck Count:%d\nLimbo Deck:%s\nDeck Count:%d\n" % [@num_plays, @player_a.count, @player_a.to_s, @player_b.count,
    @player_b.to_s, @limbo_stack.count, @limbo_stack.to_s, deckCount]
    
  end
  
			
end

