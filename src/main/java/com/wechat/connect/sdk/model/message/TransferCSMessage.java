package com.wechat.connect.sdk.model.message;

import com.wechat.connect.sdk.common.constant.Constants;

public class TransferCSMessage extends Message {

    private String kfAccount;
    private static final long serialVersionUID = 1032921858876745237L;

    public TransferCSMessage(String... kfAccount) {
        if (kfAccount != null && kfAccount.length > 0 && !kfAccount[0].isEmpty()) {
            this.kfAccount = kfAccount[0];
        }
        this.setMessageType(Constants.MESSAGE_TYPE_TRANSFER_CS);
    }

    public TransferCSMessage(Message receivedMessage, String... kfAccount) {
        super(receivedMessage);
        if (kfAccount != null && kfAccount.length > 0 && !kfAccount[0].isEmpty()) {
            this.kfAccount = kfAccount[0];
        }
        this.setMessageType(Constants.MESSAGE_TYPE_TRANSFER_CS);
    }

    private static final String EMPTYTEMPLATE = "";
    private static final String XMLTEMPLATE = 
        "<TransInfo><KfAccount>%s</KfAccount></TransInfo>" + "\n";

    @Override
    public String toXML() {
        String baseTemplate = super.toXML();
        String template = null == kfAccount ? EMPTYTEMPLATE : String.format(XMLTEMPLATE, kfAccount);
        return baseTemplate.replace(Constants.TEMPLATE_REEPLACE_STR, template);
    }

    @Override
    public String toJSON() {
        String baseTemplate = super.toJSON();
        return baseTemplate.replace(Constants.TEMPLATE_REEPLACE_STR, EMPTYTEMPLATE);
    }
}
