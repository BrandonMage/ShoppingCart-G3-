var rules = {
    "start": ["#NP# #VP#."],
    "NP": ["#Det# #N#", "#Det# #N# that #VP#", "#Det# #Adj# #N#"],
    "VP": ["#Vtrans# #NP#", "#Vintr#"],
    "Det": ["The", "This", "That"],
    "N": ["John Keating", "Bob Harris", "Bruce Wayne", "John Constantine", "Tony Stark", "John Wick", "Sherlock Holmes", "King Leonidas"],
    "Adj": ["cool", "lazy", "amazed", "sweet"],
    "Vtrans": ["computes", "examines", "helps", "prefers", "sends", "plays with", "messes up with"],
    "Vintr": ["coughs", "daydreams", "whines", "slobbers", "appears", "disappears", "exists", "cries", "laughs"]
}
let sentences = []
function generate() {
    var data = {
    
            "start": ["#NP# #VP#."],
            "NP": ["#Det# #N#", "#Det# #Adj# #N#", "#N# that #VP#"],
            "VP": ["#Vtrans# #NP#", "#Vintr# #PP#"],
            "PP": ["#Prep# #NP#"],
            "Det": ["The", "This", "That", "Some", "Many", "Any"],
            "N": ["dog", "cat", "book", "computer", "car", "house", "chair", "tree", "person", "city"],
            "Adj": ["happy", "sad", "big", "small", "fast", "slow", "young", "old"],
            "Vtrans": ["reads", "eats", "buys", "likes", "watches", "sells", "gives"],
            "Vintr": ["sleeps", "thinks", "dreams", "runs", "walks", "talks", "jumps"],
            "Prep": ["in", "on", "at", "with", "to", "from"]
          
    }
    
    let grammar = tracery.createGrammar(data);
    let expansion = grammar.flatten('#start#');

    sentences.push(expansion);

    printSentences(sentences);
}

function printSentences(sentences) {
    let textBox = document.getElementById("sentences");
    textBox.innerHTML = "";
    for(let i=sentences.length-1; i>=0; i--) {
        textBox.innerHTML += "<p>"+sentences[i]+"</p>"
    }
}