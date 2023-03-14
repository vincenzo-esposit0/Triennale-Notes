function flipCoin() {
  if (Math.random() < 0.5) {
    return("Heads");
  } else {
    return("Tails");
  }
}

function max(n1, n2) {
  if (n1 >= n2) {
    return(n1);
  } else {
    return(n2);
  }
}

function dayName(dayNumber) {
  var dayName;
  switch(dayNumber) {
    case 0: dayName = "Sunday"; break;
    case 1: dayName = "Monday"; break;
    case 2: dayName = "Tuesday"; break;
    case 3: dayName = "Wednesday"; break;
    case 4: dayName = "Thursday"; break;
    case 5: dayName = "Friday"; break;
    case 6: dayName = "Saturday"; break;
    default: dayName = "Invalid Day"; break;
  }
  return(dayName);
}

var coin = (Math.random() > 0.5) ? "Heads" : "Tails";

function flipCoin2() {
  return((Math.random() > 0.5) ? "Heads" : "Tails");
}

function count(n) {
  for(var i=0; i<n; i++) {
    console.log("i is %o", i)
  }
}

function powersOf2(max) {
  var num = 2;
  while(num < max) {
    console.log("num is %o", num);
    num = num * 2;
  }
}