
/// <reference path="../typings/jquery/jquery.d.ts" />

class NotifUI{
    constructor(message?:string){
        $("#notif").append('<div class="notifBox"><b>'+message+'</b></div> <br><br>');
    }
}

interface IObservable {
    addObserver(observer:IObserver):void;
    removeObserver( observer:IObserver):void;
    notifyAll():void;
}

interface IObserver {
    update(): void;
}

class MessageRepository implements IObserver {   
    update(): void{
        this.addMessage();
    }
    addMessage():void {
        var notif=  new NotifUI("sendMessage=>Something new happened in Stock");
    }
}
class StatisticRepository  implements IObserver{
     update():void{
           var notif=  new NotifUI("Statistics => Update Stock statistics !");
    }
}

class Stock implements IObservable {
    observers:Array<IObserver>= [];
    addObserver(observer:IObserver):void {
         this.observers.push(observer);
    }
    removeObserver( observer:IObserver):void{
        var item = this.observers.indexOf(observer, 0);
        if (item != undefined) {
                this.observers.splice(item, 1);
        }
    }
    notifyAll():void{
        this.observers.forEach(o=>o.update());
    }
}


class Main {
    private statistics:StatisticRepository = new StatisticRepository();
    private message:MessageRepository = new MessageRepository();
    private stock: Stock = new Stock();

    constructor() {
        this.init();
        this.initUI();
    }
    
    public init(){
        this.stock.addObserver(this.statistics);
        this.stock.addObserver(this.message);
    }
    public initUI() {
        $('#changeStock').click(this.bindChangeBtn);
    }
    private bindChangeBtn = (event) => {
        this.stock.notifyAll();
    }

}

window.onload = () => {
    var main = new Main();
     
};