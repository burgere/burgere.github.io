# CSC 243-401
# Assignment 8
# Eric Burger

# Write doc strings for full credit

import os

rules={'Virus1':'iyfp9fg394g539gf',
       'Virus2':'9f8g8408h3498hff'}

# Question 1
# Put here for your reference only
# DO NOT MODIFY
def originalscan(pathname, signatures):
    'a version from the CSC 242 students'
    for item in os.listdir(pathname):
        n = os.path.join(pathname, item)
        try:
            originalscan(n, signatures) 
        except:
            f = open(n, 'r')
            s = f.read()
            for virus in signatures:
                if s.find(signatures[virus]) > 0:
                    print('{}, found virus {}'.format(n,virus))
            f.close()

# Write this function for the assignment
def scan(pathname, signatures, depth):
    '''modification of virus scanning function, takes a third parameter that represents
    the depth of subdirectories that should be scanned.'''
    if depth < 0:
        return
    elif depth == 0:
        for i in os.listdir(pathname):
            item = os.path.join(pathname, i)
            try:
                for virus in signatures:
                    if open(item).read().find(signatures[virus]) >= 0:
                        print('{}, found virus {}'.format(item, virus))
            except:
                continue
    else:                
        for item in os.listdir(pathname):
            nextItem = os.path.join(pathname, item)
            try:
                scan(nextItem, signatures, depth - 1)
            except:
                for virus in signatures:
                    if open(nextItem).read().find(signatures[virus]) >= 0:
                        print('{}, found virus {}'.format(nextItem, virus))

# Question 2
def traverse(path, indent):
    '''prints the pathname of every file and subfolder contained in a folder.
    Output with indentation that corresponds to depth.'''
    indentSpace = "  "
    for item in os.listdir(path):
        nextItem = os.path.join(path, item)
        print((indentSpace * indent) + nextItem)
        try:
            traverse(nextItem, indent + 1)
        except:
            continue

#Question 3
def search(fname, path):
    '''Searches files and subdirectories in path to find file fname. Returns the
    pathname of the file if it is found, returns None if it cannot be found.'''
    for item in os.listdir(path):
        nextItem = os.path.join(path, item)
        if os.path.isdir(nextItem):
            s = search(fname, nextItem)
            if s:
                return s
        elif os.path.isdir(nextItem) == False:
            if fname == item:
                return nextItem
    return None

def searchInClass(fname, path):
    for item in os.listdir(path):
        if fname == item:
            return os.path.join(path, item)
        itemPath = os.path.join(path, item)
        try:
            p = search(fname, itemPath)
            if p != None:
                return p
        except:
            pass # this is not the file you want
    #All the searches failed
    return None
           
#Question 4
def fileCount(path):
    '''returns the number of files found in path and in the subdirectories of path.'''
    count = 0
    for item in os.listdir(path):
        newPath = os.path.join(path, item)
        if os.path.isdir(newPath):
            count += fileCount(newPath)
        else:
            count += 1    
    return count
        
        
    

