package ninja.zhancheng.tacospring.Messaging;

import ninja.zhancheng.tacospring.Domain.Order;

public interface OrderMessagingService {

    void sendOrder(Order order);

}