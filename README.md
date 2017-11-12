# confIOMessenger

Messenger bot for confIO

### launch

launch with "-conf conf/dev.json"
### add menu to bot
```
curl -X POST -H "Content-Type: application/json" -d '{
"persistent_menu":[
     {
         "locale": "default",
         "composer_input_disabled": false,
         "call_to_actions": [
           {
             "title": "Venue",
             "type": "postback",
             "payload": "VENUE"
           },
           {
             "title": "FAQ",
             "type": "postback",
             "payload": "FAQ"
           }
         ]
       },
       {
         "locale": "zh_CN",
         "composer_input_disabled": false
       }
  ] 
}' "https://graph.facebook.com/v2.6/me/messenger_profile?access_token=YOUR_ACCESS_TOKEN_HERE"
```