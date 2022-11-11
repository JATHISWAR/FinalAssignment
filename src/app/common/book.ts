export class Books{
    constructor(
        public id: number,
        public name:String,
        public author:String,
        public publisher:String,
        public type:String,
        public price:number,
        public issueDate:String,
        public returnDate:String
    ){

    }
}