/**
 * @module
 * @mergeModuleWith <project>
 */

import { MessageBus } from "./message_bus.js";
import { EmailConstructor } from "./email_constructor.js";
import { Emailer } from "./emailer.js";
import { OrderConfirmation } from "./models/order_confirmation.js";

console.log("the hoistname and port are:" + process.env.RABBITMQ_HOST! + process.env.RABBITMQ_PORT!);
const message_bus = await MessageBus.createInstance(`amqp://${process.env.RABBITMQ_HOST!}:${process.env.RABBITMQ_PORT!}`, process.env.EMAIL_SERVICE_RABBITMQ_QUEUE!);
const email_constructor = new EmailConstructor();
const emailer = await Emailer.createInstance();

message_bus.on('order_confirmation', async (order_confirmation: OrderConfirmation) => {
    const html = email_constructor.construct(order_confirmation);

    if (html) {
        emailer.sendEmail(order_confirmation, html);
    }
})

message_bus.listen();