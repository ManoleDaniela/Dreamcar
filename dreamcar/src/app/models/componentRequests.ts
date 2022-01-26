export class ComponentRequests{
    idReq: number;
    componentName: string;
    quantity: number;
    targetPrice: number;
    limitTime: Date;
    idWinner: number;
    winnerName?: string;
    isClosed: boolean;
    minimumBid?:number;
}